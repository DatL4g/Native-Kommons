package dev.datlag.kommons


data object Angola : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("AGO")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(24)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(244)
    override val continent: Continent = Continent.Africa
}