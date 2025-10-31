package dev.datlag.kommons


data object Taiwan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TWN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(158)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(886)
    override val continent: Continent = Continent.Asia
}