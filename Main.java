//cria a interface Strategy
interface EnvioStrategy {
    double calcularCusto(double distancia);
}
//Estrategias concretas implementam a interface Strategy e adaptam o método
//Estrategia de envio padrao
class envioPadrao implements EnvioStrategy {
    @Override
    public double calcularCusto(double distancia) {
        // Cálculo do custo
        return 2.0 + (0.05 * distancia);
    }
}
//Estrategia da entrega rápida
class entregaRapida implements EnvioStrategy {
    @Override
    public double calcularCusto(double distancia) {
        // Cálculo do custo
        return 10.0 + (0.1 * distancia);
    }
}
//Estrategia de envio imediato
class envioImediato implements EnvioStrategy {
    @Override
    public double calcularCusto(double distancia) {
        // Cálculo do custo
        return 20.0 + (0.15 * distancia);
    }
}
//Contexto, definido pela classe pedido
class Pedido {
    //Definida a referência para a estratégia
    private EnvioStrategy envioStrategy;
    public void setEnvioStrategy(EnvioStrategy envioStrategy) {
        this.envioStrategy = envioStrategy;
    }
    public double processarPedido(double distancia) {
        if (envioStrategy == null) {
            throw new IllegalStateException("Estratégia de envio não definida.");
        }
        return envioStrategy.calcularCusto(distancia);
    }
}
public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        double distancia = 150;
        // Escolhendo o envio padrão
        pedido.setEnvioStrategy(new envioPadrao ());
        System.out.println("Custo do envio padrão: " + pedido.processarPedido(distancia));
        // Mudando para entrega rápida
        pedido.setEnvioStrategy(new entregaRapida());
        System.out.println("Custo da entrega rápida: " + pedido.processarPedido(distancia));
        // Mudando para envio imediato
        pedido.setEnvioStrategy(new envioImediato());
        System.out.println("Custo do envio imediato: " + pedido.processarPedido(distancia));
    }
}