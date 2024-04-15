package br.com.fiap.challenge.service;

import br.com.fiap.challenge.dto.EmpresaDTO;
import br.com.fiap.challenge.model.Empresa;
import br.com.fiap.challenge.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaDTO> listarTodasEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<EmpresaDTO> encontrarEmpresaPorId(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.map(this::convertToDto);
    }

    public EmpresaDTO salvarEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = convertToEntity(empresaDTO);
        Empresa empresaSalva = empresaRepository.save(empresa);
        return convertToDto(empresaSalva);
    }

    public void deletarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDTO convertToDto(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        BeanUtils.copyProperties(empresa, empresaDTO);
        return empresaDTO;
    }

    private Empresa convertToEntity(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        BeanUtils.copyProperties(empresaDTO, empresa);
        return empresa;
    }
}
