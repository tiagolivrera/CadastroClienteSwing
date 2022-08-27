package br.com.tiagolivrera.cadastroclienteswing.dao;

import br.com.tiagolivrera.cadastroclienteswing.domain.Cliente;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author thyago
 */
public class ClienteSetDAO implements IClienteDAO {

    private Set<Cliente> set;
    private static ClienteSetDAO instancia;

    private ClienteSetDAO() {
        set = new TreeSet<>();
    }

    public static synchronized ClienteSetDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClienteSetDAO();
        }
        return instancia;
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (set.contains(cliente)) {
            return false;
        }
        set.add(cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        for (Cliente c : set) {
            if (c.getCpf().equals(cpf)) {
                set.remove(c);
                break;
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        for (Cliente c : set) {
            if (c.getCpf().equals(cliente.getCpf())) {
                c.setCidade(cliente.getCidade());
                c.setEstado(cliente.getEstado());
                c.setEndereco(cliente.getEndereco());
                c.setNome(cliente.getNome());
                c.setNumero(cliente.getNumero());
                c.setTelefone(cliente.getTelefone());
                break;
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        Cliente cliente = null;
        for (Cliente c : set) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }
        return cliente;
    }
}
