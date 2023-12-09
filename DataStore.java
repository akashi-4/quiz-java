import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * Esta classe representa um armazenamento de dados contendo informações relacionadas ao usuário,
 * incluindo nome de usuário, data e listas de perguntas corretas e incorretas.
 *
 * @version 1.0
 * @author João Furukawa
 * @author Mateus Lima
 */
public class DataStore implements Serializable {
    /**
     * O nome de usuário associado a este armazenamento de dados.
     */
    String username;

    /**
     * A data e hora em que os dados foram armazenados.
     */
    LocalDateTime data;

    /**
     * Lista de perguntas respondidas corretamente.
     */
    ArrayList<Pergunta> perguntasCertas = new ArrayList<Pergunta>();

    /**
     * Lista de perguntas respondidas incorretamente.
     */
    ArrayList<Pergunta> perguntasErradas = new ArrayList<Pergunta>();
}
