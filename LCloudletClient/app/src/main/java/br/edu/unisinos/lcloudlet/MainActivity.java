package br.edu.unisinos.lcloudlet;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.UnknownHostException;

import br.edu.unisinos.lcloudlet.R;
import br.edu.unisinos.lcloudlet.api.MimeType;
import br.edu.unisinos.lcloudlet.api.Cloudlet;

public class MainActivity extends Activity {

    private String offloadableJSCode =
            "function heavyAlgorithm(n) {"
                    + "var result = n;"
                    + "for (var i = 0; i < n; i++) {"
                    + "for (var j = 0; j < n; j++) {"
                    + "result = (result * i + j) % n;"
                    + "}"
                    + "}"
                    + "return result;"
                    + "}";

    private Cloudlet cloudlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        findViewById(R.id.process).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onclickProccess();
            }
        });
    }

    private void onclickProccess() {
        long startTime = System.currentTimeMillis();

        Long n = getN();
        Long localExecutionTreshold = getTreshold();

        if (n <= localExecutionTreshold) {
            writeResponse(String.valueOf(heavyAlgorithm(n)));

            writeResponse("Result: " + heavyAlgorithm(getN())
                    + "\nProcessing time: " + (System.currentTimeMillis() - startTime) + "ms"
                    + "\n(Executed Locally)");

        } else {
            try {
                writeResponse("Result: " + remoteHeavyAlgorithm(getN())
                        + "\nProcessing time: " + (System.currentTimeMillis() - startTime) + "ms"
                        + "\n(Executed on: " + getCloudletAddress() + ")");
            } catch (UnknownHostException e) {
                writeResponse("Cloudlet not found: " + getCloudletAddress());
            } catch (Exception e){
                e.printStackTrace();
                writeResponse("Error to offload the processing." + e.getMessage());
            }
        }


    }

    private Long getTreshold() {
        return Long.valueOf(((EditText) findViewById(R.id.threshold)).getText().toString());
    }

    private void writeResponse(String response) {
        ((TextView) findViewById(R.id.result))
                .setText(response);
    }

    private Long getN() {
        return Long.valueOf(((EditText) findViewById(R.id.n)).getText().toString());
    }

    private double remoteHeavyAlgorithm(Long n) throws UnknownHostException {
        if (cloudlet == null) {
            cloudlet = new Cloudlet(getCloudletAddress());
        }

        if(!cloudlet.checkService("heavyAlgorithm")) {
            cloudlet.registerService("heavyAlgorithm", "heavyAlgorithm", offloadableJSCode, MimeType.APPLICATION_JAVASCRIPT);
        }
        return Double.valueOf(cloudlet.executeService("heavyAlgorithm", n));
    }

    private String getCloudletAddress() {
        return ((EditText) findViewById(R.id.cloudletAddress)).getText().toString();
    }

    public double heavyAlgorithm(Long n) {
        double result = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = (result * i + j) % n;
            }
        }
        return result;
    }
}
