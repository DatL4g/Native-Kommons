package dev.datlag.kommons


data object NorthMacedonia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MK")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MKD")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(807)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(389)
    override val continent: Continent = Continent.Europe
}