class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " - запуск.");
        try {
            for(int count=0; count <10; count++) {
                Thread.sleep(400);
                System.out.println("B " + getName() + ", счётчик: " + count);
            }
        }
        catch (InterruptedException exc) {
            System.out.println(getName() + " - прерван.");
        }
        System.out.println(getName() + " - завершение.");
    }
    public static MyThread createAndStart (String name) {
        MyThread myThrd = new MyThread(name);

        myThrd.start();
        return myThrd;
    }
}

class ExtendThread {
    public static void main(String args[]) {
        MyThread mt = MyThread.createAndStart("Порождённый поток #1");

        //mt.start();

        for(int i=0; i<50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException exc){
                System.out.println("Прерываение основного потока.");
            }
        }
        System.out.println("Завершение основного потока.");
    }
}