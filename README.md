## Caso de uso: Compra y transacciones en línea con tarjeta de crédito

Descripción:
El siguiente caso de uso describe el proceso de compra y transacciones en línea utilizando una tarjeta de crédito. El objetivo es proporcionar una visión general de las interacciones y los pasos involucrados en este proceso.

Actores:
- Usuario: Persona que realiza la compra en línea.
- Sistema de Pago: Sistema encargado de procesar los pagos y transacciones con tarjeta de crédito.

Flujo del caso de uso:

1. El Usuario selecciona los productos o servicios que desea comprar en el sitio web de comercio electrónico.
2. El Usuario procede a realizar el pago y elige la opción de pago con tarjeta de crédito.
3. El Sistema de Pago solicita al Usuario los detalles de la tarjeta de crédito, como el número de tarjeta, fecha de vencimiento y código de seguridad.
4. El Usuario ingresa los detalles de la tarjeta de crédito y envía la solicitud de pago al Sistema de Pago.
5. El Sistema de Pago valida los detalles de la tarjeta de crédito, realiza una verificación de seguridad y verifica la disponibilidad de fondos en la cuenta asociada a la tarjeta.
6. Si los detalles de la tarjeta son válidos y hay fondos suficientes, el Sistema de Pago procesa la transacción y realiza el cargo en la tarjeta de crédito del Usuario.
7. El Sistema de Pago devuelve una respuesta al Usuario indicando si la transacción fue exitosa o no.
8. El Usuario recibe la confirmación de la transacción y el comercio electrónico actualiza el estado del pedido como "pagado".
9. En caso de que la transacción sea rechazada, el Usuario puede intentar nuevamente con otra tarjeta de crédito o cancelar la compra.
10. Fin del caso de uso.

Este caso de uso describe el flujo básico de una transacción de compra en línea utilizando una tarjeta de crédito. Sin embargo, ten en cuenta que en un sistema real, se deben considerar aspectos de seguridad adicionales, como el encriptado de los datos de la tarjeta, la autenticación del titular de la tarjeta y la prevención de fraudes.

## Diagrama de Secuencia

![Diagrama de Secuencia](diagrama.png)

