/**
 * Classe que representa uma pergunta de Ski, um subtipo de perguntas de Desporto.
 *
 * @version 1.0
 * @author Joao Furukawa
 * @author Mateus Lima
 */
public class Ski extends Desporto{
    /**
     * Construtor para perguntas de Ski.
     *
     * @param pergunta O texto da pergunta.
     * @param resposta A resposta correta da pergunta.
     * @param opcoes   As opções de resposta da pergunta.
     */
    public Ski(String pergunta, String resposta, String[] opcoes){
        super(3,2,pergunta, resposta, opcoes);
        this.majoracao = 2;
    }
    /**
     * Calcula a pontuação para perguntas de Ski.
     *
     * @return A pontuação calculada.
     */
    @Override
    public int calculaPontos(){
        int pontuacao = (this.pontos * this.majoracao) + 3;
        return pontuacao;
    }
}
