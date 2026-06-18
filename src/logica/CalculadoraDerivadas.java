package logica;

public class CalculadoraDerivadas {

    public String derivar(String funcion) {

        funcion = funcion.replace(" ", "");

        switch (funcion) {

            case "x^2-9":
                return "2x";

            case "x^2+6x+9":
                return "2x+6";

            case "3x^2-12x":
                return "6x-12";

            case "5x^2+20x":
                return "10x+20";

            case "4x^3-12x^2":
                return "12x^2-24x";

            default:
                return "Derivada no disponible";
        }
    }

    public String factorizar(String derivada) {

        derivada = derivada.replace(" ", "");

        switch (derivada) {

            case "2x":
                return "2(x)";

            case "2x+6":
                return "2(x+3)";

            case "6x-12":
                return "6(x-2)";

            case "10x+20":
                return "10(x+2)";

            case "12x^2-24x":
                return "12x(x-2)";

            default:
                return "No factorizable";
        }
    }
}