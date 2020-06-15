package com.dawidciesielski;

public class Main {

    public static void main(String[] args) {
	    final PolitePerson jay = new PolitePerson("Jay");
        final PolitePerson garry = new PolitePerson("Garry");

        new Thread(new Runnable() {
            @Override
            public void run() {
                jay.sayHello(garry);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                garry.sayHello(jay);

            }
        }).start();

    }

    static class PolitePerson {
        private final String NAME;

        public PolitePerson (String NAME) {
            this.NAME = NAME;

        }

        public String getNAME () {
            return NAME;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me%n", this.NAME, person.getNAME());
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me%n", this.NAME, person.getNAME());
        }
    }
}
