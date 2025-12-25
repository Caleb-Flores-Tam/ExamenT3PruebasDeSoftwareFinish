@mobile @reservas @smoke
Feature: Crear reservación
  Scenario: Crear una reservación desde la app
    Given que el Usuario abrió la app AutoReserva
    Then debería ver el texto "Reservas de Autos"
    When crea una reservación con:
      | placa   | modelo         | cliente | fecha      |
      | XYZ-123 | Toyota Corolla | Victor  | 2025-12-20 |
    Then debería ver la reservación "XYZ-123" en el listado

  Scenario: Editar una reservación existente
    Given que el Usuario abrió la app AutoReserva
    Then debería ver el texto "Reservas de Autos"
    And existe una reservación con:
      | placa  | modelo | cliente | fecha      |
      | ED-001 | Kia Rio| Ana     | 2025-12-20 |
    When edita la reservación "ED-001" con:
      | modelo        | cliente | fecha      |
      | Kia Rio Sport | Ana     | 2025-12-21 |
    Then debería ver la reservación "ED-001" en el listado

  Scenario: Eliminar una reservación existente
    Given que el Usuario abrió la app AutoReserva
    Then debería ver el texto "Reservas de Autos"
    And existe una reservación con:
      | placa   | modelo | cliente | fecha      |
      | DEL-001 | Mazda 3| Luis    | 2025-12-20 |
    When elimina la reservación "DEL-001"
    Then no debería ver la reservación "DEL-001" en el listado