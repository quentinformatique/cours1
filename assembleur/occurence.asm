org 100h
jmp debut  

   Tableau DW 1 DUP (9, 10, 4, 9, 3, 15, 9, 1, 7, 6)
   nombre DW 9
   occurence DW 0 

debut:

   MOV BX, offset Tableau
   MOV CX, 10   
   MOV AX, nombre
   MOV SI, 0
   
   boucle:
      CMP [BX][SI], AX
      JNE NonEgal
         INC occurence
      NonEgal:
         ; if vide
      ADD SI, 2
      LOOP boucle
      


ret




