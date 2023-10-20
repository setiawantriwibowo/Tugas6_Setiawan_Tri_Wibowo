Feature: Klik Backhome
  @Test
  Scenario: Backhome dari halaman complete order
    Given User sudah selesai cekout
    When user click backhome
    Then redirect homepage