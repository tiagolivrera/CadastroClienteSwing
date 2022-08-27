package br.com.tiagolivrera.cadastroclienteswing.dao;

import br.com.tiagolivrera.cadastroclienteswing.domain.Cliente;

/**
 *
 * @author thyago
 */
public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

}
