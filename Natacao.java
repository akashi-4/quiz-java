/**
 * Classe que representa uma pergunta do tipo Natação.
 *
 * @version 1.0
 * @authors Joao Furukawa
 * @author Mateus Lima
 */
public class Natacao extends Desporto {

    /**
     * Construtor para perguntas de Natação.
     *
     * @param pergunta  A pergunta sobre Natação.
     * @param resposta  A resposta correta para a pergunta.
     * @param opcoes    As opções de resposta para a pergunta.
     */
    public Natacao(String pergunta, String resposta, String[] opcoes) {
        super(3, 3, pergunta, resposta, opcoes);
        this.majoracao = 10;
    }

    /**
     * Calcula a pontuação total para perguntas de Natação.
     *
     * @return A pontuação total.
     */
    @Override
    public int calculaPontos() {
        int pontuacao = this.pontos + this.majoracao + 3;
        return pontuacao;
    }
}
