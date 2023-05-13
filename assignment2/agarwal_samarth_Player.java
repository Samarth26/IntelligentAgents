class agarwal_samarth_Player extends Player{
    int selectAction(int n, int[] myHistory, int[] oppHistory1, int[] oppHistory2) {
        // Default round where player defects
        int roundDefect = 10;
        //Create Boolean Variables to remember if opp1 or 2 played a different move than us
        boolean madeDifferentMove1 = false;
        boolean madeDifferentMove2 = false;
        if (n == roundDefect) { // Defect once to find players which always coop in round x
            return 1;
        }
        for (int i = 0; i < n; i++) {
            // variables keeping track of ith move of the player
            int opp1Move = oppHistory1[i];
            int opp2Move = oppHistory2[i];
            int myMove = myHistory[i];
            //if my move is different from the first or second opponent's move
            //set boolean variable to true
            if(myMove != opp1Move){
                madeDifferentMove1 = true;
            }
            if(myMove != opp2Move){
                madeDifferentMove2 = true;
            }
            // if my history has ever been different from both opp then we defect
            // This means that we are playing against two players who are not us
            if (madeDifferentMove1 && madeDifferentMove2) { 
                return 1; // Defect; Not playing against ourselves
            }
        }
        // Cooperate; It gets us the most points when there are two of us or when there are three of us
        return 0; 
    }
}