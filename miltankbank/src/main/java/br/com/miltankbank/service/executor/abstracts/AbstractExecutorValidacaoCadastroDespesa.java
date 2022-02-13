package br.com.miltankbank.service.executor.abstracts;

import java.time.LocalDate;
import java.util.Optional;

import br.com.miltankbank.exceptions.despesa.DespesaDuplicadaException;
import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.acao.AcaoCadastroDespesa;


public class AbstractExecutorValidacaoCadastroDespesa implements AcaoCadastroDespesa{
    private final DespesaRepository despesaRepository;

    public AbstractExecutorValidacaoCadastroDespesa(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    @Override
    public void executa(DespesaForm despesaForm) {
        Optional<Despesa> optDespesa = despesaRepository.findByDescricaoDespesa(despesaForm.getDescricaoDespesa());
        if (optDespesa.isPresent()) {
            if (despesaForm.getDataDespesa().getMonth().equals(optDespesa.get().getDataDespesa().getMonth())) {
                throw new DespesaDuplicadaException("Não pode ter duas despesas com a mesma descrição no mesmo mês");
            }
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataDespesa = optDespesa.get().getDataDespesa();
            if (dataAtual.getMonthValue() == dataDespesa.getMonthValue()) {
                throw new DespesaDuplicadaException("Não pode ter duas despesas com a mesma descrição no mesmo mês");
            }
        }
        
    }
    
}
