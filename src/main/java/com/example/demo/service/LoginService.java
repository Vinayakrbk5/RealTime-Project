package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EnvironmentDTO;
import com.example.demo.dto.LoginDTO;

public interface LoginService {
	
	public String validateAndSave(LoginDTO dto,List<EnvironmentDTO> envList);
	
	public String validateAndSaveBulkData(String url);

}
