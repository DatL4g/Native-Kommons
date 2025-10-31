package dev.datlag.kommons


data object HongKong : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("HK")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("HKG")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(344)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(852)
    override val continent: Continent = Continent.Asia
}