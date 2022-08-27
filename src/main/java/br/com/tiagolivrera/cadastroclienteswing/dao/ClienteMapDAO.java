package br.com.tiagolivrera.cadastroclienteswing.dao;

import br.com.tiagolivrera.cadastroclienteswing.domain.Cliente;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author thyago
 */
public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;
    private static ClienteMapDAO instancia;

    private ClienteMapDAO() {
        map = new TreeMap<>();
    }

    // sem usar a palavra-chave synchronized, poderia-se criar outras instancias dessa classe usando múltiplas threads.
    public static synchronized ClienteMapDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClienteMapDAO();
        }
        return instancia;
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = map.get(cpf);
        map.replace(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEndereco(cliente.getEndereco());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setTelefone(cliente.getTelefone());
        clienteCadastrado.setEstado(cliente.getEstado());
    }

    @Override
    public Cliente consultar(Long cpf) {
        return map.get(cpf);
    }

}
