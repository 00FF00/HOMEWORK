import java.util.Scanner;

public class TicketCmd {
    public static void main(String[] args){
        int default_price = 2;
        int price = args.length > 0 ? Integer.parseInt(args[0]) : default_price;
        TicketMachine ticketMachine = new TicketMachine(price);
        ticketMachine.setPrice(price);
        Scanner scanner = new Scanner(System.in);  // Define the input object, because there is a lot of input to be used

        while (true){
            System.out.println("----------****欢迎使用自动售票机****----------");
            System.out.print("本机销售固定票价为" +price + "元的车票");
            while (true){
                System.out.println();
                System.out.println("请选择您想进行的操作：");
                System.out.println("1、投币");
                System.out.println("2、打印车票");
                System.out.println("3、找零");
                System.out.println("4、改变票价");
                System.out.println("reset 重置");
                System.out.println("turn off 关机");
                String input = scanner.nextLine();
                switch (input){
                    case "1":
                        System.out.print("请投币：");
                        int amount = scanner.nextInt();
                        scanner.nextLine();
                        if (amount < 0) {
                            System.out.println("请正常投币");
                        } else{
                            ticketMachine.insetMoney(amount);
                        }
                        System.out.println("当前余额为：" + ticketMachine.getBalance() + "元");
                        break;

                    case "2":
                        ticketMachine.printTicket();
                        System.out.println("当前余额为：" + ticketMachine.getBalance() + "元");
                        break;

                    case "3":
                        System.out.print("找零：" + ticketMachine.refundBalance() + "元");
                        System.out.println("，请收好零钱");
                        break;

                    case"4":
                        System.out.println("当前票价：" + ticketMachine.getPrise() + "元");
                        System.out.print("请输入新的票价：");
                        int newPrice = scanner.nextInt();
                        scanner.nextLine();
                        if(newPrice < 0){
                            System.out.println("输入的票价错误！");
                        }else {
                            ticketMachine.setPrice(newPrice);
                            System.out.println("票价更换成功！当前票价：" + ticketMachine.getPrise() + "元");
                        }
                        break;

                    case "reset":
                        System.out.println("本次运营总收入：" + ticketMachine.getTotal() + "元" );
                        ticketMachine.reset();
                        System.out.println("----------****本机已被重置****----------");
                        break;

                    case "turn off":
                        System.out.println("----------****感谢您的使用****----------");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("请输入正确的服务选项！");
                }

            }

        }
    }
}
