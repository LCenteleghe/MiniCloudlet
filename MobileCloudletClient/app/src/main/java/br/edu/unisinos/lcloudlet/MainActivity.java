package br.edu.unisinos.lcloudlet;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.UnknownHostException;

import br.edu.unisinos.lcloudlet.api.Cloudlet;
import br.edu.unisinos.lcloudlet.api.MimeType;
import unisinos.edu.br.lcloudlet.R;

public class MainActivity extends Activity {

    private Cloudlet cloudlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        findViewById(R.id.process).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onclickProcess();
            }
        });
    }

    private void onclickProcess() {
        clearResponseField();

        try {
            Long n = getN();
            Long localExecutionTreshold = getTreshold();

            long startTime = System.currentTimeMillis();

            long qttNumbersSumUpToFive;
            if (n < localExecutionTreshold) {
                qttNumbersSumUpToFive = countNumbersSumupTo(n, 5L);
                writeResponse("Executed locally.");
            } else {
                qttNumbersSumUpToFive = countPrimeNumbersRemotely(n);
                writeResponse("Executed remotelly on " + cloudlet);
            }

            writeResponse("Total quantity of numbers between 0 and " + n + " that sum up to 5: " + qttNumbersSumUpToFive);
            writeResponse("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");
        } catch (UnknownHostException e) {
            writeResponse("Cloudlet not found: " + getCloudletAddress());
        } catch (Exception e) {
            e.printStackTrace();
            writeResponse("Error to offload the processing:" + e.getMessage());
        }
    }

    private void clearResponseField() {
        ((TextView) findViewById(R.id.result)).setText("");
    }

    private Long getTreshold() {
        return Long.valueOf(((EditText) findViewById(R.id.threshold)).getText().toString());
    }

    private void writeResponse(String response) {
        ((TextView) findViewById(R.id.result))
                .append(response + "\n");
    }

    private Long getN() {
        return Long.valueOf(((EditText) findViewById(R.id.n)).getText().toString());
    }

    private long countPrimeNumbersRemotely(Long n) throws UnknownHostException {
        if (cloudlet == null) {
            cloudlet = new Cloudlet(getCloudletAddress());
        }

        if (!cloudlet.checkService("numberCounter")) {
            cloudlet.registerService("numberCounter", getResources().getString(R.string.offloadable_code), MimeType.APPLICATION_JAVASCRIPT);
        }
        return (long)Double.parseDouble(cloudlet.executeService("numberCounter", "countNumbersSumupTo", n, 5L));
    }

    private String getCloudletAddress() {
        return ((EditText) findViewById(R.id.cloudletAddress)).getText().toString();
    }

    /**
     * Counts the quantity of numbers between 0 an N that sum up to the targetNumber.
     */
    public long countNumbersSumupTo(Long n, Long targetNumber) {
        long count = 0;
        for (long i = 0; i < n; i++){
            for (long k = 0; k < n; k++){
                if(i + k == 5){
                    count++;
                }
            }
        }

        return count;
    }
}
