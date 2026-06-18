package logica;

public class CalculadoraDerivadas {

    public String derivar(String funcion) {

        funcion = funcion.replace(" ", "");

        switch (funcion) {

            case "x":
                return "1";

            case "x2":
                return "2x";

            case "x3":
                return "3x2";

            case "x4":
                return "4x3";

            case "2x2":
                return "4x";

            case "5x3":
                return "15x2";

            default:
                return "No implementada";
        }

    }

    public String factorizar(String derivada) {

        derivada = derivada.replace(" ", "");

        // 4x = 4(x)
        if (derivada.matches("\\d+x")) {

            String coef = derivada.replace("x", "");

            return coef + "(x)";
        }

        // 15x2 = 15(x²)
        if (derivada.matches("\\d+x2")) {

            String coef = derivada.replace("x2", "");

            return coef + "(x²)";
        }

        // 4x3 = 4(x³)
        if (derivada.matches("\\d+x3")) {

            String coef = derivada.replace("x3", "");

            return coef + "(x³)";
        }
        return derivada;
    }
}
