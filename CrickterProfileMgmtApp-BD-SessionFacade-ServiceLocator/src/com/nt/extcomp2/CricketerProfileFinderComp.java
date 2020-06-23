package com.nt.extcomp2;

import com.nt.dto.CricketerIdDTO;
import com.nt.dto.CricketerProfileDTO;

public interface CricketerProfileFinderComp {
     public  CricketerProfileDTO  getProfileById(CricketerIdDTO idDTO);
}
