package school.sptech;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.RedeInterface;

import java.util.List;
public class dadosMaquina {
    private Looca looca;
    private Processador cpu;
    private Memoria ram;

    private List<Volume> volumes;
    private List<RedeInterface> interfaces;

    public dadosMaquina(Looca looca, Processador cpu, Memoria ram) {
        this.looca = looca;
        this.cpu = cpu;
        this.ram = ram;
        this.volumes = volumes;
        this.interfaces = interfaces;
    }
    //public dadosMaquina(){}

    public Processador getCpu() {
        return cpu;
    }

    public Memoria getRam() {
        return ram;
    }

    public List<RedeInterface> getInterfaces() {
        return interfaces;
    }

    private Double conversaoGB (Long numero) {
        return numero * Math.pow(10, -9);
    }

    private Double conversaoGB (Double numero) {
        return numero * Math.pow(10, -9);
    }

    public Double getPorcentagemUsoCpu () {
        return cpu.getUso();
    }

    public Double getPorcentagemUsoRam () {
        Double ramTotal = this.conversaoGB(ram.getTotal());
        Double ramEmUso = this.conversaoGB(ram.getEmUso());

        Double porcentagemDeUso = (ramEmUso * 100) / ramTotal;

        return porcentagemDeUso;
    }

    public Double getTaxaDeTransferencia () {
        double bytesEnviados = 0.0;
        double bytesRecebidos = 0.0;

        for (RedeInterface interfaceAtual :
                interfaces) {
            bytesEnviados += interfaceAtual.getBytesEnviados();
            bytesRecebidos += interfaceAtual.getBytesRecebidos();
        }

        return conversaoGB((bytesEnviados + bytesRecebidos) / 2);
    }

    public Double getPacotesEnviados () {
        double pacotesEnviados = 0.0;

        for (RedeInterface interfaceAtual :
                interfaces) {
            pacotesEnviados += interfaceAtual.getPacotesEnviados();
        }

        return pacotesEnviados / interfaces.size();
    }

    public Double getArmazenamentoTotal () {
        return this.conversaoGB(looca.getGrupoDeDiscos().getTamanhoTotal());
    }

    public Double getArmazenamentoUsado () {
        Double armazenamentoUsado = 0.0;

        for (Volume volumeAtual :
                volumes) {
            armazenamentoUsado += volumeAtual.getTotal() - volumeAtual.getDisponivel();
        }

        return this.conversaoGB(armazenamentoUsado);
    }
}
