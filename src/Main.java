// 4-й класс - сложный тип для использования в других классах
class ComplexType {
    private String name;

    public ComplexType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Enum для использования в одном из полей
enum Status {
    ACTIVE,
    INACTIVE,
    UNKNOWN
}

// 1-й класс в иерархии
class FirstLevel {
    private int id;
    private ComplexType complexField;
    private Status status;

    public FirstLevel(int id, ComplexType complexField, Status status) {
        this.id = id;
        this.complexField = complexField;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public ComplexType getComplexField() {
        return complexField;
    }

    public Status getStatus() {
        return status;
    }
}

// 2-й класс в иерархии
class SecondLevel extends FirstLevel {
    private String description;

    public SecondLevel(int id, ComplexType complexField, Status status, String description) {
        super(id, complexField, status);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getComplexField().getName() +
                ", Status: " + getStatus() + ", Description: " + description);
    }

    public void printDetails(String prefix) {
        System.out.println(prefix + ": ID: " + getId() + ", Name: " + getComplexField().getName() +
                ", Status: " + getStatus() + ", Description: " + description);
    }

    public final void printSimple() {
        System.out.println("Simple: ID: " + getId() + ", Description: " + description);
    }
}

// 3-й класс в иерархии (final class)
final class ThirdLevel extends SecondLevel {

    public ThirdLevel(int id, ComplexType complexField, Status status, String description) {
        super(id, complexField, status, description);
    }

    @Override
    public void printDetails() {
        System.out.println("Third Level - ID: " + getId() + ", Name: " + getComplexField().getName() +
                ", Status: " + getStatus() + ", Description: " + getDescription());
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        ComplexType complexType = new ComplexType("Complex Object");

        SecondLevel objectA = new SecondLevel(1, complexType, Status.ACTIVE, "Second Level Object");
        ThirdLevel objectB = new ThirdLevel(2, complexType, Status.INACTIVE, "Third Level Object B");
        ThirdLevel objectC = new ThirdLevel(3, complexType, Status.UNKNOWN, "Third Level Object C");

        // Печать свойств объектов и вызов перегруженных методов
        objectA.printDetails();
        objectA.printDetails("Prefix");
        objectA.printSimple();

        objectB.printDetails();
        objectC.printDetails();
    }
}
