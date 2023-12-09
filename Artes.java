/**
 * Classe que representa uma pergunta de Artes, um tipo de pergunta.
 *
 * @version 1.0
 * @author Joao Furukawa
 * @author Mateus Lima
 */
public class Artes extends Pergunta{

    /**
     * Construtor para perguntas de Artes.
     *
     * @param pergunta O texto da pergunta.
     * @param resposta A resposta correta da pergunta.
     * @param opcoes   As opções de resposta da pergunta.
     */
    public Artes(String pergunta, String resposta, String[] opcoes){
        super(1,0,pergunta, resposta, opcoes);
        this.majoracao = 10;
    }

    /**
     * Calcula a pontuação para perguntas de Artes.
     *
     * @return A pontuação calculada.
     */
    @Override
    public int calculaPontos(){
       int pontuacao = this.pontos * this.majoracao;
       return pontuacao;
    }
}
