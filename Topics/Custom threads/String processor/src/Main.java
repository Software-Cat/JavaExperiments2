/*
 * Copyright © Bowen Wu 2020.
 * All rights reserved.
 */

import java.util.Locale;
import java.util.Scanner;

class StringProcessor extends Thread {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            String line = scanner.nextLine();

            if (line.toUpperCase(Locale.ROOT).equals(line)) {
                break;
            }

            System.out.println(line.toUpperCase(Locale.ROOT));
        }

        System.out.println("FINISHED");
    }
}
