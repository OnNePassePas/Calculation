import java.util.Scanner;

public class Calculation {

    private static String DISTANCE_TRAVELED_LABEL = "пройденное расстояние, км";
    private static String SPENT_FUEL_LABEL        = "количество израсходованного топлива, литров";
    private static String LITER_PRICE_LABEL       = "стоимость литра топлива, руб.";

    private double distanceTraveled; // пройденное расстояние
    private double spentFuel; // израсходованное топливо
    private double literPrice; // цена за литр топлива

    // установка пройденного расстояния, с проверками на корректность
    public void setDistanceTraveled(String value) {
        try {
            this.distanceTraveled = Double.parseDouble(value);
            if (this.distanceTraveled < 0) {
                throw new NumberFormatException("Значение меньше нуля");
            }
        } catch (NumberFormatException e) {
            System.out.printf("Неверное значение (%s)\n", DISTANCE_TRAVELED_LABEL);
            System.exit(0);
        }
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    // установка израсходованного топлива, с проверками на корректность
    public void setSpentFuel(String value) {
        try {
            this.spentFuel = Double.parseDouble(value);
            if (this.spentFuel < 0) {
                throw new NumberFormatException("Значение меньше нуля");
            }
        } catch (NumberFormatException e) {
            System.out.printf("Неверное значение (%s)\n", SPENT_FUEL_LABEL);
            System.exit(0);
        }
    }

    public double getSpentFuel() {
        return this.spentFuel;
    }

    // установка цены за литр, с проверками на корректность
    public void setLiterPrice(String value) {
        try {
            this.literPrice = Double.parseDouble(value);
            if (this.literPrice < 0) {
                throw new NumberFormatException("Значение меньше нуля");
            }
        } catch (NumberFormatException e) {
            System.out.printf("Неверное значение (%s)\n", LITER_PRICE_LABEL);
            System.exit(0);
        }
    }

    public double getLiterPrice() {
        return this.literPrice;
    }

    // функция для считывания данных с клавиатуры, и установка значения - пройденного расстояния
    private void inputDistanceTraveled(Scanner in) {
        System.out.printf("Введите %s: ", DISTANCE_TRAVELED_LABEL);
        this.setDistanceTraveled(in.next());
    }

    // функция для считывания данных с клавиатуры, и установка значения - израсходованного топлива
    private void inputSpentFuel(Scanner in) {
        System.out.printf("Введите %s: ", SPENT_FUEL_LABEL);
        this.setSpentFuel(in.next());
    }

    // функция для считывания данных с клавиатуры, и установка значения - цены за литр
    private void inputLiterPrice(Scanner in) {
        System.out.printf("Введите %s: ", LITER_PRICE_LABEL);
        this.setLiterPrice(in.next());
    }

    // функция рассчета данных
    private void calc() {
        // расчет расхода топлива
        //double resultFuelConsumption  = (this.spentFuel / this.distanceTraveled) * 100;
        double resultFuelConsumption = this.delim_fuel(this.spentFuel, this.distanceTraveled);
        // расчет стоимости топлива
        //double resultCostOfFuel       = this.literPrice * this.spentFuel;
        double resultCostOfFuel = this.cost_fuel(this.literPrice, this.spentFuel);
        // расчет стоимости 1 км пути
        //double resultCostOneKilometer = (resultFuelConsumption * this.literPrice) / 100;
        double resultCostOneKilometer = this.cost_km (resultFuelConsumption, this.literPrice);
        System.out.printf("\n\tРасход топлива: %.2f л / 100 км\n\tСтоимость топлива: %.2f руб.\n\tСтоимость 1 км: %.2f руб.\n", resultFuelConsumption, resultCostOfFuel, resultCostOneKilometer);
    }
    
    // функция расхода топлива
    private double delim_fuel (double a, double b) {
        // Проверка на валидность
        if (a <= 0 || b <= 0)
            return 0;
        
        return (a/b)*100;
    }
    
    // функция стоимости топлива
    private double cost_fuel (double a, double b) {
        // Проверка на валидность
        if (a <= 0 || b <= 0)
            return 0;
        
        return a*b;
    }
    
    // функция стоимости 1 км пути
    private double cost_km (double a, double b) {
        // Проверка на валидность
        if (a <= 0 || b <= 0)
            return 0;
        
        return (a*b)/100;
    }

    // инициализация проекта
    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXX\n\nРасчет расхода топлива");
        this.inputDistanceTraveled(in);
        this.inputSpentFuel(in);
        this.inputLiterPrice(in);
        this.calc();
        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXX\n\n");
    }
}
