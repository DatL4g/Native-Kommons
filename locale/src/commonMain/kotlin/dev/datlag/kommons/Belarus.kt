package dev.datlag.kommons


data object Belarus : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BY")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BLR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(112)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(375)
}