-- KARIM ZINNATULLIN
DELIMITER $$
CREATE PROCEDURE `cancelarReserva` (in idReserva int,in idCliente int)
BEGIN
UPDATE reservas SET estado = 'C' WHERE idreservas = idReserva and idcliente = idCliente;

END$$
DELIMITER ;
call cancelarReserva(5,2);