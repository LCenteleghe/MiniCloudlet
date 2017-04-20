    function countNumbersSumupTo(n, targetNumber) {
        var count = 0;
        for (var i = 0; i < n; i++){
            for (var k = 0; k < n; k++){
                if(i + k == 5){
                    count++;
                }
            }
        }

        return count;
    }