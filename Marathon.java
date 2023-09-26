public class Marathon {
    public static void main(String[] argunebts) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"
        };

        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265
        };
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ":" + times[i]);
        }
        bestRunnerprintArrays(names,times);
    }
    public static void bestRunnerprintArrays(String[] names,int[] times){
        int fastestTimes = times[0];
        int fastestRunnerTimes = 0;
        for (int i = 1; i < times.length; i++) {
            if (fastestTimes > times[i]) {
                fastestTimes = times[i];
                fastestRunnerTimes = i;

            }
        }
        System.out.println(fastestTimes);
        System.out.println("FirstFastestRunner is" + names[fastestRunnerTimes] + ":" + times[fastestRunnerTimes]);
        secondRunnerprintArrays(names,times,fastestTimes);
    }

    public static void secondRunnerprintArrays(String[] names,int[] times,int time){

        int SecondTimes = times[0];
        int SecondRunnerTimes = 0;
        for (int i = 0; i < times.length; i++) {
            if (time < SecondTimes && times[i] > time) {
                SecondTimes = times[i];
                SecondRunnerTimes = i;
            }
        }
        System.out.println("FastestTimes" + time);
        System.out.println("SecondBestRunner is" + names[SecondRunnerTimes] + ":" + times[SecondRunnerTimes]);

    }


}
