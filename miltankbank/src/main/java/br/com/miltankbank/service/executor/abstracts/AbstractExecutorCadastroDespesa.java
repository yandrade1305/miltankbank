package br.com.miltankbank.service.executor.abstracts;


import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.acao.AcaoCadastroDespesa;

public abstract class AbstractExecutorCadastroDespesa implements AcaoCadastroDespesa{

    private final DespesaRepository despesaRepository;

    public AbstractExecutorCadastroDespesa(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    @Override
    public void executa(DespesaForm despesaForm) {
        Despesa despesa = new Despesa(despesaForm);
        if (despesaForm.getCategoria() == null) {
            despesa.setIdCategoria(8L);
        } else {
            despesa.setIdCategoria(despesaForm.getCategoria().getIdCategoria());
        }
        despesaRepository.save(despesa);
        despesaForm.setIdDespesa(despesa.getIdDespesa());
    }

}
