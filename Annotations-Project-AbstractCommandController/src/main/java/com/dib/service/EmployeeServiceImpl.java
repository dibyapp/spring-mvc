package com.dib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dib.bo.EmployeeBO;
import com.dib.bo.EmployeeResultBO;
import com.dib.dao.EmployeeDAO;
import com.dib.dto.EmployeeDTO;
import com.dib.dto.EmployeeResultDTO;

@Service("/empService")
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeDAO dao;
	@Override
	public List<EmployeeResultDTO> search(EmployeeDTO dto) 
	{
		List<EmployeeResultDTO> listRDTO=new ArrayList<EmployeeResultDTO>();
		List<EmployeeResultBO> listRBO=null;
		EmployeeBO bo=null;
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
	
		
		listRBO=dao.find(bo);
		
		listRBO.forEach(rbo->{
			EmployeeResultDTO rdto=new EmployeeResultDTO();
			BeanUtils.copyProperties(rbo, rdto);
			listRDTO.add(rdto);
		});

		return listRDTO;
	}

}
