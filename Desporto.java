/**
 * Classe que representa uma pergunta do tipo Desporto.
 */
public class Desporto extends Pergunta {

    /**
     * Construtor para perguntas de desporto sem opções fáceis e resposta adicional.
     */
    public Desporto(int tipo, int subtipo, String pergunta, String resposta, String[] opcoes) {
        super(tipo, subtipo, pergunta, resposta, opcoes);
        this.majoracao = 3;
    }

    /**
     * Construtor para perguntas de desporto com opções fáceis e resposta adicional.
     */
    public Desporto(int tipo, int subtipo, String pergunta, String resposta, String[] opcoes, String[] opcoesEz, String resposta2) {
        super(tipo, subtipo, pergunta, resposta, opcoes, opcoesEz, resposta2);
        this.majoracao = 3;
    }

    /**
     * Calcula a pontuação total da pergunta de desporto.
     *
     * @return A pontuação total.
     */
    @Override
    public int calculaPontos() {
        int pontuacao = this.pontos + this.majoracao;
        return pontuacao;
    }
}
