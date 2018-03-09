package ru.stepik.javaBasicCourse;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StepikJavaBasic_4_3_9 {

    public static void main(String[] args) {
//        MailMessage mailMessage = new MailMessage("Message1", "Message2", "Message3");
//        Package pack = new Package("weapons", 100);
//        MailPackage mailPackage = new MailPackage("from", "to", pack);


    }


    public static interface Sendable {
        String getFrom();
        String getTo();
    }

    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }
    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }
    }

    /*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }


    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }








    public static class UntrustworthyMailWorker implements MailService {
        MailService[] arrMailService = null;
        RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] arrMailService) {
            this.arrMailService = arrMailService;
        }

        public RealMailService getRealMailService() {
            return this.realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable someMail = mail;
            for (MailService ms : this.arrMailService){
                someMail = ms.processMail(someMail);
            }
            return realMailService.processMail(someMail);
        }
    }

    public static class Spy implements MailService {
        protected static Logger spy = null;

        public Spy(Logger logger) {
            spy = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(Person.AUSTIN_POWERS) || mail.getTo().equals(Person.AUSTIN_POWERS)) {
                    spy.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else
                    spy.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        protected int stolenValue = 0;
        protected int minimalCost = 0;

        public Thief(int minimalCost) {
            this.minimalCost = minimalCost;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() >= minimalCost) {
                    stolenValue += ((MailPackage) mail).getContent().getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package("stones instead of "
                            + ((MailPackage) mail).getContent().getContent(), 0));
                } else return mail;
            } else return mail;
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) throws IllegalPackageException, StolenPackageException {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getContent().equals(Person.WEAPONS) ||
                    ((MailPackage) mail).getContent().getContent().equals(Person.BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                } else if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {}
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {}
    }

    public static class Person {
        public static final String AUSTIN_POWERS = "Austin Powers";
        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";
    }
}