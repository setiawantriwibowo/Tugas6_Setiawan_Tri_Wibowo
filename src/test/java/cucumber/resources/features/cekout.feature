Feature: Cekout Barang

  @Test
  Scenario: Cekout tanpa barang
    Given User sudah login saucedemo
    When user klik cart
    And klick Cekout
    And input firstname
    And input Lastname
    And input postcode
    And klik continue
    Then muncul cekout overview
    Then klik Finish

  @Test
  Scenario: Cekout dengan Barang
    Given User sudah login saucedemo
    When user klik add to cart
    And user klik cart
    And klick Cekout
    And input firstname
    And input Lastname
    And input postcode
    And klik continue
    Then muncul cekout overview
    Then klik Finish
    Then Cekout Finish

  @Test
  Scenario: Cekout tanpa information detail
    Given User sudah login saucedemo
    When user klik add to cart
    And user klik cart
    And klick Cekout
    And klik continue
    Then muncul pesan error


