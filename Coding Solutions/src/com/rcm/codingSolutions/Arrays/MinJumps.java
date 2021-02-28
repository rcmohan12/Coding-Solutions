/**
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or .
 * The player must avoid the thunderheads.
 * Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud.
 * It is always possible to win the game.
 *
 * For each game, you will get an array of clouds numbered  if they are safe or  if they must be avoided.
 *
 * Example:
 * c = [0, 1, 0, 0, 0, 1, 0]
 *
 * Index the array from 0...6.
 * The number on each cloud is its index in the list so the player must avoid the clouds at indices 1 and 5.
 * They could follow these two paths: 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6 .
 * The first path takes 3 jumps while the second takes 4. Return 3.
 *
 */
class MinJumps {


    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0,1,0,0,0,1,0}));
    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        if(c.length == 0 || c[0] == 1) {
            return 0;
        }

        if(c.length == 1) {
            return 1;
        }
        int x = 0;
        while(x < c.length) {
            if(x+2 < c.length && c[x+2] !=1) {
                x = x+2;
                count++;
            } else if (x+1 < c.length && c[x+1] !=1)  {
                x = x+2;
                count++;
            }
        }

        return count;
    }


}