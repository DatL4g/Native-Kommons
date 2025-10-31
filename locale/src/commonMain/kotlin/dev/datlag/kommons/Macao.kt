package dev.datlag.kommons


data object Macao : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MAC")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(446)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(853)
    override val continent: Continent = Continent.Asia
}