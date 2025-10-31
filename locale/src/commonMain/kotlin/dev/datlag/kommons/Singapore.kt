package dev.datlag.kommons


data object Singapore : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SGP")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(702)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(65)
    override val continent: Continent = Continent.Asia
}