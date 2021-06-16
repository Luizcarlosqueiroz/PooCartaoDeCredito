package validation;

import basicas.Vendedor;

public class VendedorNegocio {
    
    public void inserirCliente(Vendedor vendedor) throws Exception{
        if (vendedor == null) {
            throw new Exception("Insira os dados do vendedor.");
        }
        
        if (vendedor.getCnpj() == null) {
            throw new Exception("Insira o CNPJ.");
        }
        if (vendedor.getNomeFantasia() == null) {
            throw new Exception("Insira o nome fantasia.");
        }
        if (vendedor.getEndereco() == null) {
            throw new Exception("Insira o endereço do lojista.");
        }
                
        if (vendedor.getCnpj().replaceAll("\\D+","").length() != 14){
            throw new Exception("O CNPJ deve ter 14 números.");
        }
        
        if (vendedor.getNomeFantasia().length() < 5) {
            throw new Exception("O nome não pode conter menos de 5 caracteres.");
        }
        if (vendedor.getNomeFantasia().length() > 40) {
            throw new Exception("O nome não pode conter mais de 40 caracteres.");
        }
        
        if (vendedor.getEndereco().length() < 5) {
            throw new Exception("O nome não pode conter menos de 5 caracteres.");
        }
        if (vendedor.getEndereco().length() > 50) {
            throw new Exception("O nome não pode conter mais de 40 caracteres.");
        }
    }
    
}
