import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner in = new Scanner(System.in);
    Random random = new Random();
    static Integer[] levizjetgjithsej= {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    public void play() {
        System.out.println("Welcome to Tic Tac Toe!");

        while (true||playAgain()) {
            char[] tabela = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

            char[] germat = getLojtarig();
            char lojtarg = germat[0];
            char germaKompjuter= germat[1];

            String rradha = iPari();

            boolean isPlaying = true;

            while (isPlaying) {
                if (rradha.equals("Lojtari")) {
                    printtabela(tabela);
                    int levizja = getLevizjenLojtar(tabela);
                    makeMove(tabela, lojtarg, levizja);
                    if (fitues(tabela, lojtarg)) {
                        isPlaying = false;
                    } else {
                        if (tabelaplot(tabela)) {
                            printtabela(tabela);
                            System.out.println("Barazim!");
                            break;
                        } else {
                            rradha = "Kompjuteri";
                        }
                    }
                } else {
                    int levizja = getComputerMove(tabela, germaKompjuter);
                    makeMove(tabela, germaKompjuter, levizja);
                    if (fitues(tabela, germaKompjuter)) {
                        printtabela(tabela);
                        System.out.println("Humbe!");
                        isPlaying = false;
                    } else {
                        if (tabelaplot(tabela)) {
                            printtabela(tabela);
                            System.out.println("Barazim!");
                            break;
                        } else {
                            rradha = "Lojtari";
                        }
                    }
                }
            }
            if (!playAgain()) {

                break;
            }

        }
    }


    public void printtabela(char[] tabela) {
        System.out.println("   |   |");
        System.out.println(" " + tabela[7] + " | " + tabela[8] + " | " + tabela[9]);
        System.out.println("   |   |");
        System.out.println("---+---+--");
        System.out.println("   |   |");
        System.out.println(" " + tabela[4] + " | " + tabela[5] + " | " + tabela[6]);
        System.out.println("   |   |");
        System.out.println("---+---+---");
        System.out.println("   |   |");
        System.out.println(" " + tabela[1] + " | " + tabela[2] + " | " + tabela[3]);
        System.out.println("   |   |");
    }

    public char[] getLojtarig() {
        String germa = "";

        while (!germa.equals("X") && !germa.equals("O")) {
            System.out.println("Enter X or O: ");
            germa = in.nextLine().toUpperCase();
        }
        if (germa.equals("X")) {
            char[]c=  new char[]{'X', 'O'};
            return c;
        }
        return new char[]{'O', 'X'};
    }

    public String iPari() {
        if (random.nextBoolean()) {
            return "Kompjuter";
        }
        return "Lojtari";
    }

    public boolean playAgain() {
        System.out.println("Do you want to play again? (y or n): ");
        char a = in.next().charAt(0);
        if( a == 'y'){
            return true;
        }
        else{
            return false;
        }
    }

    public void makeMove(char[] tabela, char germa, int levizja) {
        tabela[levizja] = germa;
    }

    public boolean fitues(char[] tabela, char lojtar) {
        return ((tabela[7] == lojtar && tabela[8] == lojtar && tabela[9] == lojtar) ||
                (tabela[4] == lojtar && tabela[5] == lojtar && tabela[6] == lojtar) ||
                (tabela[1] == lojtar && tabela[2] == lojtar && tabela[3] == lojtar) ||
                (tabela[7] == lojtar && tabela[4] == lojtar && tabela[1] == lojtar) ||
                (tabela[8] == lojtar && tabela[5] == lojtar && tabela[2] == lojtar) ||
                (tabela[9] == lojtar && tabela[6] == lojtar && tabela[3] == lojtar) ||
                (tabela[7] == lojtar && tabela[5] == lojtar && tabela[3] == lojtar) ||
                (tabela[9] == lojtar && tabela[5] == lojtar && tabela[1] == lojtar));
    }

    public char[] getKopjeTabela(char[] tabela) {
        char[] tabelaere = new char[tabela.length];
        for (int i = 0; i < tabela.length; i++) {
            tabelaere[i] = tabela[i];
        }
        return tabelaere;
    }

    public boolean hapsireBoshe(char[] tabela, int levizja) {
        if (levizja < 0 || levizja> 9)
            return false;
        if( tabela[levizja] == ' ')
            return true;
        else{
            return false;
        }
    }

    public int getLevizjenLojtar(char[] tabela) {
        int levizja = 0;
        while (!permbanElement(levizjetgjithsej, levizja) || !hapsireBoshe(tabela, levizja)) {
            System.out.println("What is your next move? (1-9): ");
            levizja = in.nextInt();
        }
        return levizja;
    }

    public Integer levizjeRandom(char[] tabela, int[] movesList) {
        Integer[] levizjetgjithsej= new Integer[9];

        for (int levizja : movesList) {
            if (hapsireBoshe(tabela, levizja)) {
                shtoNeHapsirenBosh(levizjetgjithsej, levizja);
            }
        }
        if (gjatesia(levizjetgjithsej) != 0) {
            int rnd = new Random().nextInt(gjatesia(levizjetgjithsej));
            return levizjetgjithsej[rnd];
        }
        return null;
    }

    public int getComputerMove(char[] tabela, char germaKompjuter) {
        char germaLojtar;
        if(germaKompjuter == 'X'){
            germaLojtar='O';
        }else{
            germaLojtar='X';
        }

        for (int i = 1; i < 10; i++) {
            char[] tabelaKopje = getKopjeTabela(tabela);
            if (hapsireBoshe(tabelaKopje, i)) {
                makeMove(tabelaKopje, germaKompjuter, i);
                if (fitues(tabelaKopje, germaKompjuter)) {
                    return i;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            char[] tabelaKopje = getKopjeTabela(tabela);
            if (hapsireBoshe(tabelaKopje, i)) {
                makeMove(tabelaKopje, germaLojtar, i);
                if (fitues(tabelaKopje, germaLojtar)) {
                    return i;
                }
            }
        }

        Integer levizja = levizjeRandom(tabela, new int[]{1, 3, 7, 9});
        if (levizja != null) {
            return levizja;
        }

        if (hapsireBoshe(tabela, 5)) {
            return 5;
        }

        return levizjeRandom(tabela, new int[]{2, 4, 6, 8});
    }

    public boolean tabelaplot(char[] tabela) {
        for (int i = 1; i < 10; i++) {
            if (hapsireBoshe(tabela, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean permbanElement(Integer[] array, int key) {
        for (Integer obj : array) {
            if (obj == null)
                continue;
            if (obj == key)
                return true;
        }
        return false;
    }

    public void shtoNeHapsirenBosh(Integer[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = num;
                break;
            }
        }
    }

    public int gjatesia(Integer[] myArray) {
        int shuma = 0;
        for (Object obj : myArray) {
            if (obj != null)
                shuma++;
        }
        return shuma;
    }
}