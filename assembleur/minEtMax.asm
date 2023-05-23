org 100h
jmp debut
   ; declaration des variables
   
   min dw ?
   max dw ?
   tableau DW 1 DUP(1,2,3,4,5,6,7,8,9,10)
   


debut:
    ; code a mettre ici
    MOV BX, offset tableau
    MOV SI, 0

    MOV AX, [BX][SI];
    MOV min,AX
    MOV max,AX

    MOV CX,10
    Boucle:
        MOV AX, max
        MOV DX, min

        CMP [BX][SI],DX
        JGE PlusGrand
            MOV DX,[BX][SI] 
            JMP Fin
        PlusGrand:
            ; rien

        CMP [BX][SI], AX
        JB Fin
            MOV AX,[BX][SI] 
            JMP Fin
        
        Fin:
            ADD  SI,2

        MOV max, AX
        MOV min, DX

        LOOP Boucle

ret