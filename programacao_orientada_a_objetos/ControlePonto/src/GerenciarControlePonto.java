import java.time.LocalDate;
import java.time.LocalDateTime;

public class GerenciarControlePonto {

    public static void main(String[] args) {

        try {
            // GERENTE
            Gerente g = new Gerente();
            g.setIdFunc(1);
            g.setNome("João Silva");
            g.setEmail("joao@email.com");
            g.setDocumento("123456");

            // SECRETARIA
            Secretaria s = new Secretaria();
            s.setIdFunc(2);
            s.setNome("Maria Oliveira");
            s.setEmail("maria@email.com");
            s.setDocumento("654321");

            // OPERADOR
            Operador o = new Operador();
            o.setIdFunc(3);
            o.setNome("Pedro Santos");
            o.setEmail("pedro@email.com");
            o.setDocumento("999999");

            // ENTRADA GERENTE
            RegistroPonto r1 = new RegistroPonto();
            r1.setFunc(g);
            r1.setDataRegistro(LocalDate.now());
            r1.setHoraEntrada(LocalDateTime.now());
            System.out.println(r1.apresentarRegistroPonto());

            Thread.sleep(1000);

            // ENTRADA OPERADOR
            RegistroPonto r2 = new RegistroPonto();
            r2.setFunc(o);
            r2.setDataRegistro(LocalDate.now());
            r2.setHoraEntrada(LocalDateTime.now());
            System.out.println(r2.apresentarRegistroPonto());

            Thread.sleep(1000);

            // ENTRADA SECRETARIA
            RegistroPonto r3 = new RegistroPonto();
            r3.setFunc(s);
            r3.setDataRegistro(LocalDate.now());
            r3.setHoraEntrada(LocalDateTime.now());
            System.out.println(r3.apresentarRegistroPonto());

            Thread.sleep(1000);

            // SAÍDAS
            r1.setHoraSaida(LocalDateTime.now());
            System.out.println(r1.apresentarRegistroPonto());

            Thread.sleep(1000);

            r2.setHoraSaida(LocalDateTime.now());
            System.out.println(r2.apresentarRegistroPonto());

            Thread.sleep(1000);

            r3.setHoraSaida(LocalDateTime.now());
            System.out.println(r3.apresentarRegistroPonto());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}