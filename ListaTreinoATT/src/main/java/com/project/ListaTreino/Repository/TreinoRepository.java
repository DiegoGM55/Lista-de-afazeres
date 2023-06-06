/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.ListaTreino.Repository;

import com.project.ListaTreino.Models.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author augus
 */
@Repository
   public interface TreinoRepository extends JpaRepository<Treino, Long> {
   }
