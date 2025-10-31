package dev.datlag.kommons


data object AmericanSamoa : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AS")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ASM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(16)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1684)
    override val continent: Continent = Continent.Oceania
}