public class Options {
    public static void mainOption() {
        System.out.println("0. Fechar programa");
        System.out.println("1. Consultar quantidade de idades");
        System.out.println("2. Manipular dados");
        System.out.println("3. Ordenar lista");
        System.out.println("4. Mais opções da lista");
        System.out.print("Resposta: ");
    }

    public static void case2() {
        System.out.println("0. Voltar");
        System.out.println("1. Adicionar idade");
        System.out.println("2. Editar idade");
        System.out.println("3. Remover idade");
        System.out.print("Resposta: ");
    }

    public static void case2Opt1() {
        System.out.println("0. Voltar");
        System.out.println("1. Adicionar quantidades predefinidas");
        System.out.println("2. Adicionar quantos quiser");
        System.out.print("Resposta: ");
    }

    public static void case2Opt3() {
        System.out.println("0. Voltar");
        System.out.println("1. Remover todas abaixo de 18");
        System.out.println("2. Remover todas acima ou iguais a 18 e abaixo de 60");
        System.out.println("3. Remover todas acima ou iguais a 60");
        System.out.println("4. Personalizar remoções");
        System.out.println("5. Remover todas as idades");
        System.out.print("Resposta: ");
    }

    public static void case4() {
        System.out.println("0. Voltar");
        System.out.println("1. Ver a soma de todas as idades");
        System.out.println("2. Ver a média e mediana das idades");
        System.out.println("3. Ver idades pares e ímpares");
        System.out.println("4. Ver quantidade de menores de idade/adultos/idosos");
        System.out.println("5. Restaurar idades removidas");
        System.out.println("6. Ver alterações da lista");
        System.out.println("7. Buscar idade");
        System.out.println("8. Restaurar todas as alterações");
        System.out.print("Resposta: ");
    }

    public static void confirmCase4Opt5() {
        System.out.println("Todas as idades que você removeu voltarão após essa ação.");
        System.out.print("Tem certeza dessa ação? [S/N]: ");
    }

    public static void confirmCase4Opt8() {
        System.out.println("Com o confirmamento dessa ação, " +
                "todas as alterações que você fez serão desfeitas, " +
                "\na lista vai voltar como era desde o início do programa!");
        System.out.print("Tem certeza dessa ação? [S/N]: ");
    }
}
