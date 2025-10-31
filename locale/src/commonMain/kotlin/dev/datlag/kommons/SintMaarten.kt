package dev.datlag.kommons


data object SintMaarten : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SX")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SXM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(534)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1721)
    override val continent: Continent = Continent.NorthAmerica
}