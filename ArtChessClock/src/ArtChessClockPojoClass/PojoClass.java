package ArtChessClockPojoClass;

import java.util.Scanner;

public class PojoClass {
    static Scanner scanner = new Scanner(System.in);
    static boolean SiyahinSirasi = false;
    static boolean BeyazinSirasi = true;
    public static boolean mainloop = true;
    static int beyazZamani = 60;
    static int siyahZamani = 60;
    static int artisMiktari = 5;
    static int secim;

    static public void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void secenekler() throws InterruptedException {
        System.out.println("-->Lutfen zaman ayari yapmak icin 1'e \n-->Kum saati modu icin 2'ye \n-->Giyotin modu icin 3'e \n" + "-->Eklemeli mod icin 4'e basiniz \n-->Cikis icin 5'e basiniz: ");
        secim = scanner.nextInt();
        if (secim >= 1 && secim <= 5) {
            switch (secim) {

                case 1:
                    adjustableTempo();
                    break;


                case 2:
                    kumSaati();
                    break;


                case 3:
                    giyotin();
                    break;

                case 4:
                    eklemeliMod();
                    break;

                case 5:
                    cikis();
                    break;

            }
        } else {
            System.out.println("Yanlis bir secim yaptiniz! Lutfen 1 ve 5 arasinda dogru bir tuslama yapiniz: ");
            secenekler();
        }
    }


    public static void cikis() {
        System.out.println("******    ART CHESS CLOCK     ******");
        System.out.println("******    ART CHESS CLOCK     ******");
        System.out.println("          Satrancla kalin!");
        System.out.println("******    ART CHESS CLOCK     ******");
        System.out.println("******    ART CHESS CLOCK     ******");
    }

    public static void sureBittiTekrar() throws InterruptedException {
        System.out.println("Baslangic erkanina cikis icin 1'i saati kapatmak icin lutfen 0'i tuslayin: ");
        int tekrar = scanner.nextInt();
        if (tekrar == 1) {
            secenekler();
        } else if (tekrar == 0) {
            cikis();
        }
    }


    public static void kumSaati() throws InterruptedException {
        KumSaatiMod ks1 = new KumSaatiMod();
        Thread threadKS1 = new Thread(ks1);
        System.out.println("   ~~~~~ KUM SAATI MODU ~~~~~");
        System.out.println("Saati baslatmak icin 0'a basin...");
        System.out.println("    Beyaz icin 1 Siyah icin 2");
        while (mainloop) {

            int kiminSirasi = scanner.nextInt();
            if (kiminSirasi == 2) {
                BeyazinSirasi = true;
                SiyahinSirasi = false;
                // siyahOynuyor.start();
            } else if (kiminSirasi == 1) {
                BeyazinSirasi = false;
                SiyahinSirasi = true;
                //  siyahOynuyor.stop();
            } else if (kiminSirasi == 0) {
                threadKS1.start();
            }
            Thread.sleep(1);
        }
    }

    public static void eklemeliMod() throws InterruptedException {
        EklemeliMod em1 = new EklemeliMod();
        Thread threadEM1 = new Thread(em1);
        System.out.println("     ~~~~~ EKLEMELI MOD ~~~~~");
        System.out.println("Saati baslatmak icin 0'a basin...");
        System.out.println("    Beyaz icin 1 Siyah icin 2");

        while (mainloop) {
            int kiminSirasi = scanner.nextInt();
            if (kiminSirasi == 2) {
                BeyazinSirasi = true;
                SiyahinSirasi = false;
            } else if (kiminSirasi == 1) {
                BeyazinSirasi = false;
                SiyahinSirasi = true;
            } else if (kiminSirasi == 0) {
                threadEM1.start();
            }
            Thread.sleep(1);
        }
    }

    public static void giyotin() throws InterruptedException {
        GiyotinMod gm1 = new GiyotinMod();
        Thread threadGM1 = new Thread(gm1);
        System.out.println("   ~~~~~ GIYOTIN MODU ~~~~~");
        System.out.println("Saati baslatmak icin 0'a basin...");
        System.out.println("    Beyaz icin 1 Siyah icin 2");

        while (mainloop) {
            int kiminSirasi = scanner.nextInt();
            if (kiminSirasi == 2) {
                BeyazinSirasi = true;
                SiyahinSirasi = false;
            } else if (kiminSirasi == 1) {
                BeyazinSirasi = false;
                SiyahinSirasi = true;
            } else if (kiminSirasi == 0) {
                threadGM1.start();
            }
            Thread.sleep(1);
        }
    }


    public static void adjustableTempo() throws InterruptedException {
        System.out.println("~~~~~ Zaman kontrolu ayarlama paneline hosgeldiniz! ~~~~~");
        System.out.println("\nLutfen saniye cinsinden secim yapiniz");
        System.out.println("Beyazin zamani: ");
        beyazZamani = scanner.nextInt();
        System.out.println("Siyahin zamani: ");
        siyahZamani = scanner.nextInt();
        System.out.println("Ekleme ayari yapmak istiyorsaniz lutfen 1 e basiniz, Satranc saatine devam etmek icin 0 a basiniz;");
        int devam = scanner.nextInt();
        if (devam == 1) {
            System.out.println("Ekleme zamani: ");
            artisMiktari = scanner.nextInt();
            secenekler();
        } else if (devam == 0) {
            secenekler();
        } else {
            System.out.println("Yanlis bir secim yaptiniz, Ana menuye yonlendiriliyorsunuz... ");
            secenekler();
        }

    }

    public void kumSaatiCalistir() {
        while (mainloop) {
            while (BeyazinSirasi) {
                System.out.println("***Hamle Beyazda***");
                siyahZamani++;
                beyazZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                    System.out.println();
                }
                PojoClass.threadSleep();

                while (SiyahinSirasi) {
                    System.out.println("***Hamle Siyahta***");
                    beyazZamani++;
                    siyahZamani--;
                    System.out.print("Beyaz: " + beyazZamani + " ");
                    System.out.print("Siyah: " + siyahZamani);
                    System.out.println();
                    if (beyazZamani <= 0 || siyahZamani <= 0) {
                        mainloop = false;
                        BeyazinSirasi = false;
                        SiyahinSirasi = false;
                    }
                    PojoClass.threadSleep();
                }
                System.out.println();
            }
        }
        if (beyazZamani == 0) {
            System.out.println("Beyaz'in zamani tukendi!!");
        } else if (siyahZamani == 0) {
            System.out.println("Siyah'in zamani tukendi!!");
        }
    }

    void giyotinModuCalistir() {
        while (mainloop) {
            while (BeyazinSirasi) {
                System.out.println("***Hamle Beyazda***");
                beyazZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                }
                PojoClass.threadSleep();
            }
            while (SiyahinSirasi) {
                System.out.println("***Hamle Siyahta***");
                siyahZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                }
                PojoClass.threadSleep();
            }
            System.out.println();
        }
        if (beyazZamani == 0) {
            System.out.println("Beyaz'in zamani tukendi!!");
        } else if (siyahZamani == 0) {
            System.out.println("Siyah'in zamani tukendi!!");
        }
    }

    public void eklemeliModCalistir() {
        while (mainloop) {
            while (BeyazinSirasi) {
                System.out.println("***Hamle Beyazda***");

                beyazZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                }
                PojoClass.threadSleep();
            }
            if (BeyazinSirasi == false)
                beyazZamani += artisMiktari;
            while (SiyahinSirasi) {
                System.out.println("***Hamle Siyahta***");
                siyahZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                }
                PojoClass.threadSleep();
            }
            if (SiyahinSirasi == false)
                siyahZamani += artisMiktari;
            System.out.println();
        }
        if (beyazZamani == 0) {
            System.out.println("Beyaz'in zamani tukendi!!");
        } else if (siyahZamani == 0) {
            System.out.println("Siyah'in zamani tukendi!!");
        }
    }
}
