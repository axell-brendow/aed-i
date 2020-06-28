/*

PUC Minas - Ciência da Computação     Nome: Contato

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 11/04/2018

*/

import IO.*;
import java.io.IOException;

public class Contato
{
    private String name, residentialAddress, professionalAddress;
    private String[] phonesList;
    
    public Contato() {}
    
    public Contato(String name, String phone)
    {
        // se o nome ou o telefone forem invalidos termina o construtor
        if (!isAValidName(name) || !isAValidPhone(phone)) return;
        
        setName(name); // coloca o nome passado no campo "name" da classe
        addPhone(phone); // adiciona o telefone 'a lista de telefones da classe
    }
    
    public Contato(String name, String phone1, String phone2)
    {
        this(name, phone1); // chama o contrutor que adiciona apenas um nome e um telefone
        
        // checa se phone2 nao e' um telefone valido
        if (!isAValidPhone(phone2)) return; // termina o construtor se for o caso
        
        addPhone(phone2); // adiciona phone2 'a lista de telefones da classe
    }
    
    /**
     * @return nome do contato
     */
    
    public String getName()
    {
        return name;
    }
    
    /**
     * Le um nome do usuario e o coloca como o nome do contato
     */
    
    public void readName() throws IOException
    {
        setName(AxellIO.readString("Informe um nome: ")); // coloca o nome lido no campo "name" da classe
    }
    
    /**
     * Associa um nome ao contato
     * @param name novo nome do contato
     */
    
    private void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Checa, superficialmente, se um nome e' valido
     * @param name nome a ser analisado
     * @return true se o nome for valido, caso contrario, false
     */
    
    private boolean isAValidName(String name)
    {
        if (name == null || name.equals(""))
        {
            AxellIO.println("");
        }
        
        return true;
    }
    
    /**
     * @return endereço residencial do contato
     */
    
    public String getResidentialAddress()
    {
        return residentialAddress;
    }
    
    /**
     * Le um endereço residencial do usuario e o coloca como o endereço residencial do contato
     */
    
    public void readResidentialAddress() throws IOException
    {
        setResidentialAddress(AxellIO.readString("Informe um endereço residencial: "));
    }
    
    /**
     * Associa um endereço residencial ao contato
     * @param residentialAddress novo endereço residencial do contato
     */
    
    private void setResidentialAddress(String residentialAdress)
    {
        this.residentialAddress = residentialAdress;
    }
    
    /**
     * @return endereço profissional do contato
     */
    
    public String getProfessionalAddress()
    {
        return professionalAddress;
    }
    
    /**
     * Le um endereço profissional do usuario e o coloca como o endereço profissional do contato
     */
    
    public void readProfessionalAddress() throws IOException
    {
        setProfessionalAddress(AxellIO.readString("Informe um endereço profissional: "));
    }
    
    /**
     * Associa um endereço profissional ao contato
     * @param professionalAdress novo endereço profissional do contato
     */
    
    private void setProfessionalAddress(String professionalAddress)
    {
        this.professionalAddress = professionalAddress;
    }
    
    public String getPhone(int index)
    {
        if (phonesList == null || limitWillBreak(index, 1, phonesList)) return null;
        
        return phonesList[index];
    }
    
    /**
     * Le um telefone do usuario e o adiciona na lista de telefones da classe
     */
    
    public void readPhone() throws IOException
    {
        String phone;
        
        do
        {
            phone = AxellIO.readString("Informe um telefone: ");
            AxellIO.println();
            
        } while (!isAValidPhone(phone)); // le um novo telefone enquanto o informado nao for valido
        
        addPhone(phone); // adiciona o telefone lido 'a lista de telefones da classe
    }
    
    /**
     * @return quantidade de telefones na lista de telefones da classe
     */
    
    public int getNumberOfPhones()
    {
        return phonesList == null ? 0 : phonesList.length;
    }
    
    /**
     * Adiciona um segundo telefone 'a lista de telefones da classe
     * @param phone segundo telefone
     */
    
    public void setPhone2(String phone) throws IOException
    {
        if (getNumberOfPhones() == 1) // checa se o contato tem apenas 1 telefone
        {
            String option;
            
            do
            {
                option = AxellIO.readString("Deseja acrescentar um numero de telefone (s-n) ? ");
                AxellIO.println();
                
            } while (!option.equals("s") && !option.equals("n"));
            
            if (option.equals("s")) // se desejar acrescentar,
            {
                addPhone(phone); // adiciona o telefone 'a lista
            }
            
            else // se nao desejar acrescentar,
            {
                setPhone(phone, 0); // muda o primeiro telefone da lista para o novo
            }
        }
    }
    
    /**
     * Coloca um novo telefone no lugar do segundo telefone da lista de telefones da classe
     * @param phone novo telefone
     */
    
    public void changePhone2(String phone)
    {
        // checa se a quantidade de telefones na lista e' menor que dois
        if (getNumberOfPhones() < 2)
        {
            AxellIO.println("Nao existe o segundo telefone na lista\n");
            return;
        }
        
        setPhone(phone, 1); // adiciona o telefone no indice 1 da lista
    }
    
    /**
     * Remove o segundo telefone da lista da classe
     */
    
    public void removePhone2()
    {
        if (getNumberOfPhones() == 1) // checa se o contato tem apenas 1 telefone
        {
            AxellIO.println("\nNao existe o segundo telefone na lista\n");
            return;
        }
        
        removePhone(1);
    }
    
    /**
     * Coloca um dado telefone num determinado indice da lista de telefones da classe
     * @param phone novo telefone
     * @param index indice da lista para coloca-lo
     */
    
    private void setPhone(String phone, int index)
    {
        if (phonesList == null || !isAValidPhone(phone) || limitWillBreak(index, 1, phonesList)) return;
        
        phonesList[index] = phone; // coloca o telefone na lista de telefones da classe
    }
    
    /**
     * Remove determinado telefone da lista da classe
     * @param index indice do telefone
     */
    
    private void removePhone(int index)
    {
        if (phonesList == null || limitWillBreak(index, 1, phonesList)) return;
        
        if (index == 0)
        {
            if (phonesList.length == 1)
            {
                phonesList = new String[1];
            }
            
            else
            {
                phonesList = copyArray(index + 1, phonesList.length - 1, phonesList);
            }
        }
        
        else if (index == phonesList.length - 1)
        {
            phonesList = copyArray(0, phonesList.length - 1, phonesList);
        }
        
        else
        {
            // cria um arranjo com 2 espacos para arranjos de String
            String[][] newPhonesListMatrix = new String[2][1];
            
            // preenche o primeiro espaco com os telefones que vao ate' antes do telefone que se deseja remover
            newPhonesListMatrix[0] = copyArray(0, index, phonesList);
            
            // preenche o segundo espaco com todos os telefones apos o telefone que se deseja remover
            newPhonesListMatrix[1] = copyArray(index + 1, phonesList.length - 1 - newPhonesListMatrix[0].length, phonesList);
            
            // diminui o tamanho da lista de telefones em uma unidade e adiciona as listas de telefone
            // que foram copiadas logo acima
            resizePhonesList(phonesList.length - 1, newPhonesListMatrix);
        }
    }
    
    /**
     * Adiciona um novo telefone 'a lista de telefones da classe
     * @param phone telefone
     */
    
    private void addPhone(String phone)
    {
        if (phonesList == null) // se phonesList nao foi inicializada,
        {
            phonesList = new String[1]; // inicializa-se ela com tamanho 1
            phonesList[0] = phone; // adiciona o primeiro telefone
        }
        
        else
        {
            // cria-se mais um espaco na lista de telefones
            resizePhonesList(phonesList.length + 1);
            
            // adiciona o novo telefone na ultima posicao da lista
            setPhone(phone, phonesList.length - 1);
        }
    }
    
    /**
     * A partir de um indice inicial, substitui os telefones da lista de telefones
     * da classe por outros telefones de outra lista
     * @param start indice inicial
     * @param newPhonesList lista novos telefones
     */
    
    private void changePhonesList(int start, String[] newPhonesList)
    {
        if (newPhonesList == null || limitWillBreak(start, newPhonesList.length, this.phonesList)) return;
        
        for (int i = 0; i < newPhonesList.length; i++)
        {
            this.phonesList[start + i] = newPhonesList[i];
        }
    }
    
    /**
     * Muda o tamanho e adiciona novas listas de telefone 'a lista da classe
     * @param size novo tamanho da lista
     * @param phonesListMatrix matriz com listas de telefones
     */
    
    private void resizePhonesList(int size, String[][] phonesListMatrix)
    {
        if (size < 1 || phonesListMatrix == null || phonesListMatrix.length == 0) return;
        
        if (phonesList == null) // se phonesList nao foi inicializada,
        {
            phonesList = new String[size]; // inicia-se ela com o tamanho dado
            return;
        }
        
        // se o novo tamanho for igual ao atual termina o metodo
        if (size == phonesList.length) return;
        
        int totalSize = 0;
        
        for (String[] list : phonesListMatrix) // percorre cada lista de telefone
        {
            totalSize += list.length; // soma os tamanhos de cada lista
        }
        
        // se os tamanhos das listas de telefones juntos excederem o novo tamanho
        // da lista de telefone da classe, termina o metodo
        if (totalSize > size) return;
        
        // inicializa a lista de telefones da classe com o novo tamanho
        phonesList = new String[size];
        
        // guardara' o ultimo indice que algo foi gravado na lista de telefones da classe + 1
        int lastIndex = 0;
        
        for (String[] phonesList : phonesListMatrix) // percorre as listas de telefone
        {
            changePhonesList(lastIndex, phonesList); // adiciona cada lista 'a lista da classe
            
            // incrimenta lastIndex com a quantidade de elementos que foi gravada
            lastIndex += phonesList.length;
        }
    }
    
    /**
     * Muda o tamanho da lista de telefones da classe perdendo o mínimo
     * possivel de telefones
     * @param size novo tamanho da lista
     */
    
    private void resizePhonesList(int size)
    {
        if (size < 1) return;
        
        if (phonesList == null) // se phonesList nao foi inicializada,
        {
            phonesList = new String[size]; // inicia-se ela com o tamanho dado
            return;
        }
        
        // se o novo tamanho for igual ao atual termina o metodo
        if (size == phonesList.length) return;
        
        // cria uma copia da atual lista de telefones
        String[] oldPhones = copyArray(0, phonesList.length, phonesList);
        
        // inicializa-se novamente a lista de telefones com o novo tamanho
        phonesList = new String[size];
        
        if (size < phonesList.length) // se o novo tamanho e' menor que o antigo,
        {
            for (int i = 0; i < size; i++) // percorre de 0 ate' novo tamanho - 1
            {
                // adiciona 'a nova lista os que estavam na lista antiga, porem,
                // so' ate' onde for possivel
                phonesList[i] = oldPhones[i];
            }
        }
        
        else // se o novo tamanho for maior que o antigo,
        {
            for (int i = 0; i < oldPhones.length; i++) // percorre de 0 ate' antigo tamanho - 1
            {
                phonesList[i] = oldPhones[i]; // adiciona todos os telefones antigos 'a nova lista
            }
        }
    }
    
    /**
     * Checa se um dado telefone se encaixa nos telefones do tipo "1111-1111"
     * @param phone telefone a se analisar
     * @return true se o telefone se encaixar no padrao, caso contrario, false
     */
    
    private boolean isAValidPhone(String phone)
    {
        if
        ( // checa, superficialmente, se o telefone informado nao se encaixa no tipo "1111-1111"
            phone == null || phone.length() != 9 ||
            phone.charAt(4) != '-' || AxellIO.getCharTimes('-', phone) != 1
        )
        {
            // avisa que o telefone dado e' invalido
            AxellIO.println("O telefone " + phone + " nao e' valido\n");
            return false;
        }
        
        boolean isAValidPhone = true;
        char c;
        
        // percorre os caracteres do telefone
        for (int i = 0; i < phone.length() && isAValidPhone; i++)
        {
            c = phone.charAt(i); // pega cada caractere
            
            // checa se e' um digito ou um traco
            isAValidPhone = AxellIO.isDigit(c) || c == '-';
        }
        
        return isAValidPhone;
    }
    
    public void fromFile(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        
        if (file.eof()) return;
        
        String line = file.readln();
        
        if (line == null) return;
        
        String[] splitedLine = line.split(" ");
        
        if (splitedLine.length < 2) return;
        
        name = splitedLine[0];
        
        // checa se a proxima informacao nao comeca com numero
        if (!AxellIO.isDigit(splitedLine[1].charAt(0)))
        {
            // se nao for numero, sera' o endereco residencial
            residentialAddress = splitedLine[1];
            
            if (splitedLine.length < 3) return;
            
            // checa se a proxima informacao nao comeca com numero
            if (!AxellIO.isDigit(splitedLine[2].charAt(0)))
            {
                // se nao for numero, sera' o endereco profissional
                professionalAddress = splitedLine[2];
                
                // a partir da quarta informacao, pega as outras que sao os telefones
                phonesList = copyArray(3, splitedLine.length - 3, splitedLine);
            }
            
            else // caso em que so' existe o endereco residencial
            {
                // a partir da terceira informacao, pega as outras que sao os telefones
                phonesList = copyArray(2, splitedLine.length - 2, splitedLine);
            }
        }
        
        else // se nao tiver nenhum endereco,
        {
            // a partir da segunda informacao, pega as outras que sao os telefones
            phonesList = copyArray(1, splitedLine.length - 1, splitedLine);
        }
        
        file.close();
    }
    
    /**
     * Funcao que obtem a representacao de certa quantidade de telefones
     * da lista da classe na forma de texto
     * @param start indice do primeiro telefone a se pegar
     * @param numberOfElements quantidade de telefones a se pegar
     * @return telefones concatenados entre espacos na forma de String
     */
    
    private String getPhonesListText(int start, int numberOfElements)
    {
        if (phonesList == null || limitWillBreak(start, numberOfElements, phonesList))
        {
            AxellIO.println("\nNao foi possivel obter a representacao em texto da lista de telefones da classe");
            return null;
        }
        
        String arrayText = "";
        
        for (int i = 0; i < numberOfElements; i++)
        {
            arrayText += phonesList[start + i] + " ";
        }
        
        return arrayText;
    }
    
    public void toFile(String fileName)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        file.print(name + " ");
        file.print(getPhonesListText(0, phonesList.length));
        
        file.close();
    }
    
    /**
     * Copia certa quantidade de elementos de um arranjo a partir
     * de um indice inicial
     * @param start indice inicial
     * @param numberOfElements quantidade de elementos
     * @param array arranjo de Strings a se copiar
     * @return arranjo de String com as String do arranjo passado
     */
    
    private String[] copyArray(int start, int numberOfElements, String[] array)
    {
        if (array == null || limitWillBreak(start, numberOfElements, array)) return null;
        
        String[] copyOfArray = new String[numberOfElements];
        
        for (int i = 0; i < numberOfElements; i++)
        {
            copyOfArray[i] = array[start + i];
        }
        
        return copyOfArray;
    }
    
    /**
     * Checa se, a partir de um indice inicial, e' impossivel acessar certa quantidade
     * de elementos ou espacos de um arranjo
     * @param start indice inicial
     * @param numberOfElements quantidade de elementos
     * @param objectArray arranjo a ser analisado
     * @return true se for impossivel, caso contrario, false
     */
    
    private boolean limitWillBreak(int start, int numberOfElements, Object[] objectArray)
    {
        if (start < 0 || numberOfElements < 1 || (start + numberOfElements) > objectArray.length)
        {
            AxellIO.println("Indice inicial (" + start + ") e a quantidade de elementos (" + numberOfElements + ") levam a erro\n");
            return true;
        }
        
        return false;
    }
}
