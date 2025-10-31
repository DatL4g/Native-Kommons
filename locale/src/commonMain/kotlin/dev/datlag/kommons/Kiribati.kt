package dev.datlag.kommons


data object Kiribati : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KIR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(296)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(686)
    override val continent: Continent = Continent.Oceania
}